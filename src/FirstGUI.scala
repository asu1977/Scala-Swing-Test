import scala.swing._

val frame = new MainFrame {
  title = "My First GUI"
  contents = Button("Click Me!")(println("Booton was clicked."))
  size = new Dimension(500, 500)
  centerOnScreen
}

frame.visible = true