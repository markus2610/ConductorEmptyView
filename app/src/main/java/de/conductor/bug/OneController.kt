package de.conductor.bug

import android.os.Bundle
import android.view.View
import butterknife.OnClick
import com.bluelinelabs.conductor.RouterTransaction


class OneController : BaseController() {

  override val layoutId: Int = R.layout.controller_one


  override fun onViewBound(view: View) {
    super.onViewBound(view)

  }

  @OnClick(R.id.btn)
  fun closeBtn() {
    router.pushController(RouterTransaction.with(SecondController()))
  }

}