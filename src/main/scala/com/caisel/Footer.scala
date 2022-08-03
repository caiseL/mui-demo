package com.caisel

import com.olvind.mui.csstype.mod.Property.FlexDirection
import com.olvind.mui.muiMaterial.{components => mui}
import com.olvind.mui.react.mod.CSSProperties
import slinky.core.FunctionalComponent
import slinky.core.annotations.react

@react object Footer {
  type Props = Unit

  private def footerStyle = CSSProperties()
    .setColor("#FFF")
    .setBackgroundColor("#222")
    .setBorderRadius(0)

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { _ =>
    def body = mui
      .Container(
        mui.Container(
          mui.Typography("MUI 5 Demo"),
          mui.Typography("Simple demo using Material UI 5")
        ),
        mui.Container(
          mui.Typography("Footer example"),
          mui.Typography("A simple footer")
        )
      )
      .style(
        CSSProperties()
          .setDisplay("flex")
          .setFlexDirection(FlexDirection.row)
          .setMargin("10px")
      )

    mui
      .Paper()(body)
      .component("footer")
      .style(footerStyle)
  }
}
