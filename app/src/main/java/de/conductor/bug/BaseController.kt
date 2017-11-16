package de.conductor.bug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bluelinelabs.conductor.Controller

abstract class BaseController(arg: Bundle?) : Controller(arg) {

  protected constructor() : this(null)

  abstract val layoutId: Int

  private var created: Boolean = false

  private lateinit var unbinder: Unbinder


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    if (!created) {
      created = true
      onCreate()
    }

    val view = inflater.inflate(layoutId, container, false)
    unbinder = ButterKnife.bind(this, view)
    onViewBound(view)

    return view
  }

  override fun onDestroyView(view: View) {
    super.onDestroyView(view)
    unbinder.unbind()
  }

  protected open fun onCreate() {}
  protected open fun onViewBound(view: View) {}
}
