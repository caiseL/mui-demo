package com.caisel

import org.scalajs.dom
import slinky.hot
import slinky.web.ReactDOM

import scala.scalajs.{LinkingInfo, js}
import scala.scalajs.js.annotation.{JSExportTopLevel, JSImport}

@JSImport("resources/index.css", JSImport.Default)
@js.native
object IndexCSS extends js.Object

object Main {
  val css = IndexCSS

  @JSExportTopLevel("main")
  def main(): Unit = {
    if (LinkingInfo.developmentMode) {
      hot.initialize()
    }

    ReactDOM.render(App(), dom.document.getElementById("root"))
  }
}
