package com.caisel.components

import com.olvind.mui.muiMaterial.{components => mui}
import slinky.core.FunctionalComponent
import slinky.core.annotations.react

@react object Dialog {
  case class Props(
      title: String,
      text: String,
      open: Boolean,
      onClose: () => Unit
  )

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] {
    props =>
      mui.Dialog(props.open)(
        mui.DialogTitle(props.title),
        mui.DialogContent(
          mui.DialogContentText(props.text)
        ),
        mui.DialogActions(
          mui.ButtonBase.normal("Close").onClick(_ => props.onClose())
        )
      )
  }
}
