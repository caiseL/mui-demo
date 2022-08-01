package com.caisel.components

import com.olvind.mui.muiMaterial.{components => mui}
import com.olvind.mui.react.mod.CSSProperties
import slinky.core.FunctionalComponent
import slinky.core.annotations.react

@react object TextField {
  case class Props(label: String, placeholder: String)

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] {
    props =>
      mui.TextField
        .OutlinedTextFieldProps()
        .label(props.label)
        .placeholder(props.placeholder)
        .style(CSSProperties().setPadding("10px 0"))
  }
}
