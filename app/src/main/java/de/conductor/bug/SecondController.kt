package de.conductor.bug

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType


class SecondController : BaseController() {

  override val layoutId: Int = R.layout.controller_second


  override fun onViewBound(view: View) {
    super.onViewBound(view)

  }

  override fun onChangeEnded(changeHandler: ControllerChangeHandler,
      changeType: ControllerChangeType) {
    super.onChangeEnded(changeHandler, changeType)

    if (changeType == ControllerChangeType.POP_EXIT) {
      activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

  }

  override fun onChangeStarted(changeHandler: ControllerChangeHandler,
      changeType: ControllerChangeType) {
    super.onChangeStarted(changeHandler, changeType)

    if (changeType == ControllerChangeType.PUSH_ENTER) {

      activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

  }



}