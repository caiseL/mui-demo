package com.caisel.widgets

import com.olvind.mui.muiIconsMaterial.{components => muiIcons}
import com.olvind.mui.muiMaterial.{
  components => mui,
  muiMaterialStrings => muiStrings
}
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.{Fragment, Hooks}

@react object SnackbarExample {
  type Props = Unit
  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { _ =>
    val (isOpen, setOpen) = Hooks.useState(false)

    def button = mui.Button
      .DefaultComponentPropsExtendButtonBaseTypAccessKey("Open snackbar")
      .onClick(_ => setOpen(true))

    def snackbarAction = mui.IconButton
      .normal(
        mui.Icon(muiIcons.Close())
      )
      .onClick(_ => setOpen(false))

    def snackbar =
      mui
        .Snackbar()
        .open(isOpen)
        .onClose((_, _) => setOpen(false))
        .autoHideDuration(3000)
        .message("Simple snackbar content")
        .action(snackbarAction)

    Fragment(
      button,
      snackbar
    )
  }
}
