package com.example.base.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.base.Constant.DB_PAGINATION_REMOTE_KEYS_TABLE


//used to store previous and next page keys in ***DB***,
// so that remote mediator will know which page to request next

//our paging 3 library or mediator will handle pagination from server automatically
//it simple means when u send get request to api, the remote mediator automatically passes page queries
//after passing the api keys and all

//https://api.unsplash.com/photos/?client_id=ACCESS_KEY&page=1&per_page=10
//NOTE from the endpoint documentation, default page is 1 and per page data is 10, so what the
//remote mediator does is that it increases ur page number by 1, so our paging library triggers
//the remote mediator to request a new page from our server

//the remote mediator will also help us catch data in our DB when u fetch new data from server

//so this DbPaginationRemoteKeys class will be used by remote mediator to know which page to request next

//remote mediator: simply request data from api and cache the data in db
//with remote mediator, i dont want to show data directly from api, instead i want to show the data
//from db, so db will act as a single source of truth, so when there is no internet connection, i can simply
//show my data without issues
@Entity(tableName = DB_PAGINATION_REMOTE_KEYS_TABLE)
data class DbPaginationRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val prevPage : Int?,
    val nextPage : Int?
)
