package com.example.grocerlypartners.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.grocerlypartners.model.OfferItem
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class UpdateOfferArgs(
  public val offer: OfferItem,
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(OfferItem::class.java)) {
      result.putParcelable("offer", this.offer as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(OfferItem::class.java)) {
      result.putSerializable("offer", this.offer as Serializable)
    } else {
      throw UnsupportedOperationException(OfferItem::class.java.name + " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(OfferItem::class.java)) {
      result.set("offer", this.offer as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(OfferItem::class.java)) {
      result.set("offer", this.offer as Serializable)
    } else {
      throw UnsupportedOperationException(OfferItem::class.java.name + " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): UpdateOfferArgs {
      bundle.setClassLoader(UpdateOfferArgs::class.java.classLoader)
      val __offer : OfferItem?
      if (bundle.containsKey("offer")) {
        if (Parcelable::class.java.isAssignableFrom(OfferItem::class.java) || Serializable::class.java.isAssignableFrom(OfferItem::class.java)) {
          __offer = bundle.get("offer") as OfferItem?
        } else {
          throw UnsupportedOperationException(OfferItem::class.java.name + " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__offer == null) {
          throw IllegalArgumentException("Argument \"offer\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"offer\" is missing and does not have an android:defaultValue")
      }
      return UpdateOfferArgs(__offer)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): UpdateOfferArgs {
      val __offer : OfferItem?
      if (savedStateHandle.contains("offer")) {
        if (Parcelable::class.java.isAssignableFrom(OfferItem::class.java) || Serializable::class.java.isAssignableFrom(OfferItem::class.java)) {
          __offer = savedStateHandle.get<OfferItem?>("offer")
        } else {
          throw UnsupportedOperationException(OfferItem::class.java.name + " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__offer == null) {
          throw IllegalArgumentException("Argument \"offer\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"offer\" is missing and does not have an android:defaultValue")
      }
      return UpdateOfferArgs(__offer)
    }
  }
}
