package sample.qiitaclient.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by insight on 17/07/09.
 */
data class Article(val id: String,
                   val title: String,
                   val url: String,
                   val user: User) : Parcelable {
    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Article> = object : Parcelable.Creator<Article> {
            override fun createFromParcel(source: Parcel): Article = source.run {
                val article = Article(readString(), readString(), readString(), readParcelable(User::class.java.classLoader))
                println("Article: ${article}")
                article
            }

            override fun newArray(size: Int): Array<Article?> = arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.run {
            writeString(id)
            writeString(title)
            writeString(url)
            writeParcelable(user, flags)
        }
    }
}
