package com.caisel.components

import com.olvind.mui.muiMaterial.{
  components => mui,
  muiMaterialStrings => muiStrings
}
import com.olvind.mui.react.mod.CSSProperties
import slinky.core.FunctionalComponent
import slinky.core.annotations.react

@react object AppBar {
  type Props = Unit

  private def navItems = List("Home", "Blog", "Contact")

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { _ =>
    def title = mui.Typography("MUI 5 Demo")

    def items =
      navItems.map { item =>
        mui.ButtonBase.normal(
          mui.Typography(item).style(CSSProperties().setPadding("0 10px"))
        )
      }

    mui
      .AppBar()
      .component("nav")
      .position(muiStrings.relative)(
        mui.Toolbar(
          title,
          items
        )
      )
  }
}
