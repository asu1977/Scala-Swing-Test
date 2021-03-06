import scala.swing._

val textArea = new TextArea
val scrollV = new ScrollPane(textArea)

def openFile: Unit ={
  val chooser = new FileChooser
  if (chooser.showOpenDialog(null)==FileChooser.Result.Approve){
    val source = scala.io.Source.fromFile(chooser.selectedFile)
    textArea.text = source.mkString
    source.close()
  }
}

def saveFile: Unit = {
  val chooser = new FileChooser
  if (chooser.showSaveDialog(null)==FileChooser.Result.Approve){
    val pw = new java.io.PrintWriter(chooser.selectedFile)
    pw.print(textArea.text)
    pw.close
  }
}

val frame = new MainFrame {
  title = "My First GUI"
  contents = scrollV
  menuBar = new MenuBar {
    contents += new Menu("File"){
      contents += new MenuItem(Action("Open"){
        openFile
      })
      contents += new MenuItem(Action("Save"){
        saveFile
      })
      contents += new Separator
      contents += new MenuItem(Action("Exit"){
        sys.exit(0)
      })
    }
  }
  size = new Dimension(500, 500)
  centerOnScreen
}

frame.visible = true