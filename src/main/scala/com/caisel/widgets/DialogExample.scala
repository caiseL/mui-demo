package com.caisel.widgets

import com.caisel.components.Dialog
import com.olvind.mui.muiMaterial.{
  components => mui,
  muiMaterialStrings => muiStrings
}
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.{Fragment, Hooks}

@react object DialogExample {
  type Props = Unit

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { _ =>
    val (isOpen, setOpen) = Hooks.useState(false)

    def button =
      mui.Button
        .DefaultComponentPropsExtendButtonBaseTypAccessKey("Open dialog")
        .onClick(_ => setOpen(true))

    def dialog =
      Dialog(
        "Example dialog",
        "This is an example of a dialog",
        isOpen,
        onClose = () => setOpen(false)
      )

    Fragment(button, dialog)
  }
}
