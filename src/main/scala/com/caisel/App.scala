package com.caisel

import com.caisel.components.{AppBar, TextField}
import com.caisel.widgets.{DialogExample, DrawerExample, SnackbarExample}
import com.olvind.mui.csstype.mod.Property.FlexDirection
import com.olvind.mui.muiMaterial.{
  components => mui,
  muiMaterialStrings => muiStrings
}
import com.olvind.mui.react.mod.CSSProperties
import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.Fragment

@react object App {
  type Props = Unit

  private def formStyle =
    CSSProperties()
      .setDisplay("flex")
      .setFlexDirection(FlexDirection.column)

  private def cardFormStyle =
    CSSProperties()
      .setMaxWidth(400)
      .setWidth("100%")
      .setDisplay("flex")
      .setAlignItems("center")
      .setJustifyContent("center")
      .setPadding("30px 0")
      .setMargin("0 auto")

  private def bodyStyle = CSSProperties()
    .setPadding("1em")
    .setDisplay("flex")
    .setFlex("auto")
    .setFlexDirection(FlexDirection.column)
    .setMinHeight("100vh")

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { _ =>
    def appBar = AppBar()

    def emailField = TextField("Email", "test@wiringbits.net")
    def passwordField = TextField("Password", "A secure password")
    def repeatPasswordField = TextField("Repeat password", "A secure password")

    def form = mui
      .Container(emailField, passwordField, repeatPasswordField)
      .style(formStyle)

    def loginWidget = {
      mui
        .Card(
          mui.CardContent(
            mui.Typography("Login form").variant(muiStrings.h4),
            form
          )
        )
        .style(cardFormStyle)
    }

    def dialog = DialogExample()

    def snackbar = SnackbarExample()

    def drawer = DrawerExample()

    def footer = Footer()

    def body =
      mui.Container(loginWidget, dialog, snackbar, drawer).style(bodyStyle)

    def child = Fragment(
      appBar,
      body,
      footer
    )

    Fragment(
      mui.CssBaseline(),
      child
    )
  }
}
