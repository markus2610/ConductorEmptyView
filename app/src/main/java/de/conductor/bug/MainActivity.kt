package de.conductor.bug

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction


class MainActivity : AppCompatActivity() {

  lateinit var router: Router

  @BindView(R.id.rootView) lateinit var container: FrameLayout

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_container)

    ButterKnife.bind(this)

    router = Conductor.attachRouter(this, container, savedInstanceState)


    if (!router.hasRootController()) {
      router.setRoot(RouterTransaction.with(OneController()))
    }

  }

  override fun onBackPressed() {
    if (!router.handleBack()) {
      super.onBackPressed()
    }
  }
}
