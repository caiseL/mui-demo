package com.caisel.widgets

import com.olvind.mui.muiMaterial.{
  components => mui,
  muiMaterialStrings => muiStrings
}
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.{Fragment, Hooks}

@react object DrawerExample {
  type Props = Unit

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { _ =>
    val (isOpen, setOpen) = Hooks.useState(false)

    def button =
      mui.Button
        .DefaultComponentPropsExtendButtonBaseTypAccessKey("Open drawer")
        .onClick(_ => setOpen(true))

    def items = List("Inbox", "Sent", "Received").map { item =>
      mui.ListItem
        .normal()
        .disablePadding(true)(
          mui.ListItemText().primary(item)
        )
        .withKey(item)
    }

    def drawerContent = mui.Box(mui.List(items)).width(250)

    def drawer =
      mui.Drawer(drawerContent).open(isOpen).onClose((_, _) => setOpen(false))

    Fragment(button, drawer)
  }
}
