package com.sergio.study.data.datasources.remote

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.sergio.study.data.api.BASE_URL_SERVICE
import com.sergio.study.data.api.VolleyNetwork
import com.sergio.study.data.dtos.UserDTO
import com.sergio.study.data.mappers.userDtoToUserDomain
import com.sergio.study.domain.models.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.suspendCancellableCoroutine
import org.json.JSONArray
import timber.log.Timber
import kotlin.coroutines.resume

class UserDataSourceRemoteImpl(private val context: Context) : UserDataSourceRemote {

    private val moshi by lazy { Moshi.Builder().add(KotlinJsonAdapterFactory()).build() }
    private val adapter by lazy { moshi.adapter(UserDTO::class.java) }

    override suspend fun getAll(): List<User> {

        return suspendCancellableCoroutine {

            val request =
                StringRequest(Request.Method.GET, BASE_URL_SERVICE,
                    Response.Listener { response ->

                        val json = JSONArray(response)
                        val usersJson = mutableListOf<User>()

                        for (i in 0 until json.length()) {
                            val user = adapter.fromJson(json.getJSONObject(i).toString())!!
                            usersJson.add(userDtoToUserDomain(user))
                        }

                        it.resume(usersJson)

                    }, Response.ErrorListener {
                        Timber.d(it)
                    })

            VolleyNetwork.getInstance(context).addToRequestQueue(request)
        }
    }

    override suspend fun getUserById(userId: Int): User {

        return suspendCancellableCoroutine { thread ->

            val url = "$BASE_URL_SERVICE$userId/"
            val request =
                JsonObjectRequest(Request.Method.GET, url, null,
                    Response.Listener { response ->

                        val usersJson = adapter.fromJson(response.toString())!!
                        thread.resume(userDtoToUserDomain(usersJson))
                    }, Response.ErrorListener {
                        Timber.d(it)
                    })

            VolleyNetwork.getInstance(context).addToRequestQueue(request)
        }
    }
}
