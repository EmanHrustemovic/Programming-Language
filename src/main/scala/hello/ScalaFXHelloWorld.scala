package hello //Paket u kojem se nalazi naš Scala code

import javafx.scene.input.MouseEvent //Importujemo MouseEvent  iz javafx paketa. Korsitimo ga za rukovanje ' događaja miša'
import scalafx.application.{JFXApp, JFXApp3} // Importuje (ovo iz zagrade) iz ScalaFX bibiloteke i koristi se pravljenje aplikacija
import scalafx.geometry.Insets // Importuje Insets klasu iz ScalaFX koji se koriste za oduzimanje prostora or rubova kontejnera
import scalafx.scene.Scene // Importuje scenu za aplikaciju
import scalafx.scene.canvas.{Canvas, GraphicsContext} // Importujemo canvas i graphics da bi dozvolio crtanje
import scalafx.scene.control.Button // Importujemo Button klasu koja predstavlja dugme
import scalafx.scene.effect.DropShadow // Importujemo klasu dropShadow koja predstavlja efekat sjenke
//import scalafx.scene.input.MouseEvent
import scalafx.scene.layout.{HBox, Pane, VBox} //Importi redom predstavljaju horizontalni , osnovni i vertikalni kontejner(redom)
import scalafx.scene.paint.* //ovaj i sledeci import objezbjeđuju korištenje boja
import scalafx.scene.paint.Color.*
import scalafx.scene.shape.{Circle, Rectangle} // predstavljaju krug i parvougaonik
import scalafx.scene.text.Text // Dozvoljava ispis texta na ekranu
import scalafx.scene.text.Font

import java.awt.Graphics2D // Importujemo 2D grafiku
import scala.language.implicitConversions // Implicitne ( direktne ) konverzije data types
import scala.util.Random // Klasa koja random generiše brojeve ( nasumičan izbor brojeva )



def renderCanvas(canvas: Canvas): Unit = { //Define a void function with parameter canvas
  val graphicsContext = canvas.graphicsContext2D; //Create a new value graphicsContext that allow us to draw on Canvas object
  // Set the background color
  graphicsContext.setFill(Color.LightGray) // Setting the background color
  graphicsContext.fillRect(0, 0, 800, 800) // Drawing rectangle with same dimensions as Canvas

  // Main Outer Outline
  graphicsContext.setStroke(Color.Gray) // Postavlja boju spoljašnjeg pravougaonika
  graphicsContext.setLineWidth(10) // Postavlja širinu linije
  graphicsContext.strokeRect(100, 100, 600, 600) // Kreira spoljašnji pravougaonik
  // Main Inner Outline
  graphicsContext.setStroke(Color.BLACK) // Postavlja boju unutrašnjeg pravougaonika
  graphicsContext.setLineWidth(10) // Postavlja širinu linije
  graphicsContext.strokeRect(120, 120, 560, 560) //Kreira unutrašnji pravougaonik

}

def home(canvas: Canvas): Unit = { // Create void function ' home ' with parameter canvas
  val graphicsContext = canvas.graphicsContext2D;//Create a new value graphicsContext that allow us to draw on Canvas object
  // Outer Line
  graphicsContext.setStroke(Color.White) //Set color of outer rectangle
  graphicsContext.setLineWidth(10) //Set width of line
  graphicsContext.strokeRect(280, 280, 200, 200) // Make a outer rectangle

  // Inner Line
  graphicsContext.setStroke(Color.White) //Set color of inner rectangle
  graphicsContext.setLineWidth(10) // Set width of line
  graphicsContext.strokeRect(320, 320, 120, 120) // Make a inner rectangle

  // Coloring Middle Space Black
  graphicsContext.setFill(Color.White) // Set color of middle space on ' white '
  graphicsContext.fillRect(330, 330, 100, 100) // Make a rectangle with corresponding dimensions

  // Printing The Text 'HOME'
  graphicsContext.setFill(Color.WHITE) //Set the color of the text
  graphicsContext.setFont(javafx.scene.text.Font.font("Arial", 20)) // Set the font of the text
  graphicsContext.fillText("HOME", 335, 365) // Wite the 'HOME ' on corresponding coordinates
}

//Define a function called renderCircle that takes parameters graphicsContext , color , Boolean value and X and Y coordinates
def renderCircle(graphicsContext: GraphicsContext, color: Color, x: Int, y: Int, size: Int, outline: Boolean): Unit = {
  if(!outline){ //Check if the outline is false so we can draw a inside of circle
    graphicsContext.setFill(color) //set color for filling the circle
    graphicsContext.fillOval(x, y, size, size) //With fillOval method , we draw a full circle (pun krug)
  } else {
    graphicsContext.setStroke(color) // Set a color of circle
    graphicsContext.setLineWidth(3);//Setting a width of line to 3
    val outlineSize = size + (10 * 2)// Calculate size of circle
    graphicsContext.strokeOval(x-10, y-10, outlineSize, outlineSize); // Crtamo krug i kružnicu
  }

}

def renderRectangle(graphicsContext: GraphicsContext, value: Int): Unit = { // Define a void function render
  // rectangle that takes Int value and graphicsContext
  val sideLength = 50.0 // crate a length variable
  val cornerRadius = 10.0 // create a radius variable

  // Draw the die outline
  graphicsContext.fill = Color.Green // Sett a fill color
  graphicsContext.stroke = Color.Red //Sett a stroke color
  graphicsContext.lineWidth = 2.0 // Set a line width to 2
  //graphicsContext.fillRoundRect(10, 10, sideLength, sideLength, cornerRadius, cornerRadius)

  // Create a rectangle
  val rectangle = new Rectangle { // this is cration of new rectangle object with corresponding width, height,
    // fill, stroke , archWidth , arcHeight
    width = sideLength
    height = sideLength
    arcWidth = cornerRadius
    arcHeight = cornerRadius
    fill = Color.Green
    stroke = Color.Red
    strokeWidth = 2.0
  }

  // Add mouse event to the rectangle
  rectangle.setOnMouseClicked((event: MouseEvent) => {


    println(s"Mouse clicked on the rectangle with value $value at (${event.getX}, ${event.getY})")
  })


  // Draw dots based on the die value
  val dotRadius = 5.0 // Set dot radius
  graphicsContext.fill = Color.Black // Set fill color on black
  graphicsContext.lineWidth = 1.0 // Set line width on 1


// Create drawDot function with which we will draw a dot with corresponding x and Y coordinates
// with corresponding radius
  def drawDot(x: Double, y: Double): Unit = {
    graphicsContext.fillOval(x - dotRadius, y - dotRadius, dotRadius * 2, dotRadius * 2)
  }
// Like switch-case in C++ , draw a certain dot corresponding to number ( when we roll dice )
  value match {
    case 1 => drawDot(35, 35)
    case 2 => drawDot(20, 20); drawDot(50, 50)
    case 3 => drawDot(20, 20); drawDot(35, 35); drawDot(50, 50)
    case 4 => drawDot(20, 20); drawDot(50, 20); drawDot(20, 50); drawDot(50, 50)
    case 5 => drawDot(20, 20); drawDot(50, 20); drawDot(35, 35); drawDot(20, 50); drawDot(50, 50)
    case 6 => drawDot(20, 20); drawDot(50, 20); drawDot(20, 35); drawDot(50, 35); drawDot(20, 50); drawDot(50, 50)
    case _ => // Do nothing for invalid values
  }
  rectangle //Returning value of rectangle
}
def rollDice(): Int = { // Define a function rollDice
  val random = new Random() //Creation of random variable of type random
  random.nextInt(6) + 1 // Generates a random number between 1 and 6
}

//Creating a void function drawCorner which take parameters : X and Y (coordinates), canvas and color
def drawCorner(canvas: Canvas, x: Int, y: Int, color: Color): Unit = {
  val graphicsContext = canvas.graphicsContext2D;//Create a new value graphicsContext that allow us to draw on Canvas object

  //outline
  renderCircle(graphicsContext, Color.Black, x, y, 100, true) // Drawing a black circle with dimensions 100 and only draw a (cuniculus)

  var changedX = x + 15 /* we change starting coordinates by 15 to down and to right */
  var changedY = y + 15
  //creating filled circles
  renderCircle(graphicsContext, color, changedX, changedY, 30, false)
  renderCircle(graphicsContext, color, changedX, changedY  + 40, 30, false)
  renderCircle(graphicsContext, color, changedX + 40, changedY, 30, false)
  renderCircle(graphicsContext, color, changedX + 40, changedY + 40, 30, false)

}

object ScalaFXHelloWorld extends JFXApp3:

  override def start(): Unit = // Method by which we will start our app

    val canvas = new Canvas(800, 800) //Creation of Canvas object and calling renderCanvas function we defined before
    renderCanvas(canvas)

    val button = new Button("Roll Dice") //Creating Button object

    val vbox = new VBox { // Creating VBox container that contain canvas and button and crating a space
      spacing = 10
      children = Seq(canvas, button)
    }

    // Wrap the Canvas in a Pane
    val rootPane = new Pane { //Creating Pane container , which is the main for JavaFX applications
      children = vbox
    }

  // Create the main window
    stage = new JFXApp3.PrimaryStage {
      title = "Ludo Game"
      scene = new Scene(800, 800) {
        root = rootPane
      }
  }


    //top corners
    drawCorner(canvas, 200, 220, Color.Green)
    drawCorner(canvas, 500, 220, Color.Blue)


    //bottom corners
    drawCorner(canvas, 200, 500, Color.Red)
    drawCorner(canvas, 500, 500, Color.Yellow)

    renderCircle(canvas.graphicsContext2D, Color.Black, 360, 150, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Green, 400, 150, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 440, 150, 15, true)

            // 4 arrays su potrebna : gornji red , donji red , desna i lijeva vertikala !



    //Prvi red ploče ili gornji dio iznad kruga

    var coordinates: Array[(Int, Int)] = Array()


    println(coordinates.mkString(","))

    renderCircle(canvas.graphicsContext2D, Color.Black, 195, 150, 15, true)
    coordinates = coordinates :+ (195,150)
    renderCircle(canvas.graphicsContext2D, Color.Black, 245, 150, 15, true)
    coordinates = coordinates :+ (245, 150)
    renderCircle(canvas.graphicsContext2D, Color.Black, 295, 150, 15, true)
    coordinates = coordinates :+ (295, 150)
    //renderCircle(canvas.graphicsContext2D, Color.Black, 345, 150, 15, true)
    //renderCircle(canvas.graphicsContext2D, Color.Black, 395, 150, 15, true)
    //renderCircle(canvas.graphicsContext2D, Color.Black, 445, 150, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 485, 150, 15, true) // zeleni kružić kod kućice :D
    coordinates = coordinates :+ (485, 150)
    renderCircle(canvas.graphicsContext2D, Color.Black, 545, 150, 15, true)
    coordinates = coordinates :+ (545, 150)
    renderCircle(canvas.graphicsContext2D, Color.Black, 595, 150, 15, true)
    coordinates = coordinates :+ (595, 150)
    //renderCircle(canvas.graphicsContext2D, Color.Black, 645, 150, 15, true)
    println(coordinates.mkString(","))
    println("-----------------------")
    println(coordinates(0))
    println(coordinates(2))
    println(coordinates(3))

    val pawn = new Pawn(50, 50) 
    pawn.draw(canvas.graphicsContext2D,100,100,0)


    //Drugi red

    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 200, 15, true)
    coordinates = coordinates :+ (400, 200)
    println(coordinates.mkString(","))
    println("-----------------------")



    //Treći red

    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 250, 15, true)
    coordinates = coordinates :+ (400, 250)


    //Četvrti red

    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 300, 15, true)
    coordinates = coordinates :+ (400,300)


    renderCircle(canvas.graphicsContext2D, Color.Black, 381, 350, 65, true)
    coordinates = coordinates :+ (381, 350)

    // Iza kruga donji dio


    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 450, 15, true)
    coordinates = coordinates :+ (400, 450)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 500, 15, true)
    coordinates = coordinates :+ (400, 500)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 550, 15, true)
    coordinates = coordinates :+ (400, 550)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 600, 15, true)
    coordinates = coordinates :+ (400, 600)
    renderCircle(canvas.graphicsContext2D, Color.Yellow, 400, 640, 15, true)
    coordinates = coordinates :+ (400, 640)

    // right flank

    renderCircle(canvas.graphicsContext2D, Color.Black, 455, 370, 15, true)
    coordinates = coordinates :+ (455, 370)
    renderCircle(canvas.graphicsContext2D, Color.Black, 495, 370, 15, true)// dodajemo na x parametar 35 , a y ostaje isti / fixan
    coordinates = coordinates :+ (495, 370)
    renderCircle(canvas.graphicsContext2D, Color.Black, 545, 370, 15, true)
    coordinates = coordinates :+ (545, 370)
    renderCircle(canvas.graphicsContext2D, Color.Black, 595, 370, 15, true)
    coordinates = coordinates :+ (595, 370)


    // left flank
    //renderCircle(canvas.graphicsContext2D,Color.Red,135,370,15,true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 195, 370, 15, true)
    coordinates = coordinates :+ (195, 370)
    renderCircle(canvas.graphicsContext2D, Color.Black, 245, 370, 15, true)
    coordinates = coordinates :+ (245, 370)
    renderCircle(canvas.graphicsContext2D, Color.Black, 295, 370, 15, true)
    coordinates = coordinates :+ (295, 370)
    renderCircle(canvas.graphicsContext2D, Color.Black, 345, 370, 15, true) // dodajemo na x parametar 35 , a y ostaje isti / fixan
    coordinates = coordinates :+ (345, 370)
    /*renderCircle(canvas.graphicsContext2D, Color.Black, 310, 370, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 345, 370, 15, true)*/

    // desna vertikala

    renderCircle(canvas.graphicsContext2D, Color.Black, 645, 150, 15, true)
    coordinates = coordinates :+ (645, 150)
    renderCircle(canvas.graphicsContext2D, Color.Black, 645, 200, 15, true)
    coordinates = coordinates :+ (645, 200)
    renderCircle(canvas.graphicsContext2D, Color.Black, 645, 250, 15, true)
    coordinates = coordinates :+ (645, 250)
    renderCircle(canvas.graphicsContext2D, Color.Black, 645, 300, 15, true)
    coordinates = coordinates :+ (645, 300)
    //renderCircle(canvas.graphicsContext2D, Color.Black, 645, 350, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 645, 335, 15, true)
    coordinates = coordinates :+ (645, 335)
    renderCircle(canvas.graphicsContext2D, Color.Blue, 645, 370, 15, true) // x ostaje isti , a y dodajmo 35
    coordinates = coordinates :+ (645, 370)
    renderCircle(canvas.graphicsContext2D, Color.Black, 645, 440, 15, true)
    coordinates = coordinates :+ (645, 440)
    renderCircle(canvas.graphicsContext2D, Color.Black, 645, 490, 15, true)
    coordinates = coordinates :+ (645, 490)
    renderCircle(canvas.graphicsContext2D, Color.Black, 645, 540, 15, true)
    coordinates = coordinates :+ (645, 540)
    renderCircle(canvas.graphicsContext2D, Color.Black, 645, 590, 15, true)
    coordinates = coordinates :+ (645, 590)
    renderCircle(canvas.graphicsContext2D, Color.Black, 645, 640, 15, true)
    coordinates = coordinates :+ (645, 640)
    /*renderCircle(canvas.graphicsContext2D,Color.Black,645,545,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,580,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,615,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,650,15,true)*/

    //lijeva vertikala


    renderCircle(canvas.graphicsContext2D, Color.Black, 145, 150, 15, true)
    coordinates = coordinates :+ (145, 150)
    renderCircle(canvas.graphicsContext2D, Color.Black, 145, 185, 15, true)
    coordinates = coordinates :+ (145, 185)
    renderCircle(canvas.graphicsContext2D, Color.Black, 145, 240, 15, true)
    coordinates = coordinates :+ (145, 240)
    renderCircle(canvas.graphicsContext2D, Color.Black, 145, 285, 15, true)
    coordinates = coordinates :+ (145, 285)
    renderCircle(canvas.graphicsContext2D, Color.Black, 145, 330, 15, true)
    coordinates = coordinates :+ (145, 330)
    renderCircle(canvas.graphicsContext2D, Color.Red, 145, 370, 15, true)
    coordinates = coordinates :+ (145, 370)
    renderCircle(canvas.graphicsContext2D, Color.Black, 145, 415, 15, true)
    coordinates = coordinates :+ (145, 415)
    renderCircle(canvas.graphicsContext2D, Color.Black, 145, 470, 15, true)
    coordinates = coordinates :+ (145, 470)
    renderCircle(canvas.graphicsContext2D, Color.Black, 145, 525, 15, true)
    coordinates = coordinates :+ (145, 525)
    renderCircle(canvas.graphicsContext2D, Color.Black, 145, 580, 15, true)
    coordinates = coordinates :+ (145, 580)
    renderCircle(canvas.graphicsContext2D, Color.Black, 145, 640, 15, true)
    coordinates = coordinates :+ (145, 640)
    /*renderCircle(canvas.graphicsContext2D,Color.Black,135,540,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,575,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,610,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,645,15,true)*/

    // donji dio

    renderCircle(canvas.graphicsContext2D, Color.Black, 195, 640, 15, true)
    coordinates = coordinates :+ (195, 640)
    renderCircle(canvas.graphicsContext2D, Color.Black, 245, 640, 15, true)
    coordinates = coordinates :+ (245, 640)
    renderCircle(canvas.graphicsContext2D, Color.Black, 295, 640, 15, true)
    coordinates = coordinates :+ (295, 640)
    renderCircle(canvas.graphicsContext2D, Color.Black, 345, 640, 15, true)
    coordinates = coordinates :+ (345, 640)
    //renderCircle(canvas.graphicsContext2D, Color.Black, 395, 640, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 445, 640, 15, true)
    coordinates = coordinates :+ (445, 640)
    renderCircle(canvas.graphicsContext2D, Color.Black, 495, 640, 15, true)
    coordinates = coordinates :+ (495, 640)
    renderCircle(canvas.graphicsContext2D, Color.Black, 545, 640, 15, true)
    coordinates = coordinates :+ (545, 640)
    renderCircle(canvas.graphicsContext2D, Color.Black, 595, 640, 15, true)
    coordinates = coordinates :+ (595, 640)


    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 200, 15, true)
    coordinates = coordinates :+ (400, 200)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 250, 15, true)
    coordinates = coordinates :+ (400, 250)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 300, 15, true)
    coordinates = coordinates :+ (400, 300)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 350, 15, true)
    coordinates = coordinates :+ (400, 350)

    renderRectangle(canvas.graphicsContext2D,3)


    //Kod za kockicu

    val dicePane = new Pane {
      val dice = new Circle()
      children = Seq(dice)
    }

    val rollButton = new Button("Roll Dice")
    val diceBox = new HBox {
      spacing = 20
      children = Seq(dicePane, rollButton)
    }

//Kod za kockicu //

/*import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.control.Button
import scalafx.scene.layout.{BorderPane, HBox, Pane}
import scalafx.scene.paint.Color

import scalafx.scene.shape.Circle*/

/* object DiceRolling extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "Rolling Dice"
    width = 400
    height = 400○99○

    val dicePane = new Pane {
      val dice = new Circle(50, Color.WHITE)
      children = Seq(dice)
    }

    val rollButton = new Button("Roll Dice")
    val diceBox = new HBox {
      spacing = 20
      children = Seq(dicePane, rollButton)
    }

    val root = new BorderPane {
      center = diceBox
    }

    scene = new Scene(root)

    rollButton.onAction = handle {
      rollDice(dicePane)
    }
  }

  private def rollDice(dicePane: Pane): Unit = {
    // Simulate dice rolling animation
    val animation = new DiceRollAnimation(dicePane)
    animation.play()
  }
}

class DiceRollAnimation(dicePane: Pane) extends javafx.animation.Transition {
  private val dice = dicePane.children.head.asInstanceOf[Circle]

 cycleDuration = javafx.util.Duration.seconds(1)

  override protected def interpolate(frac: Double): Unit = {
    // Rotate the dice during the animation
    val rotation = 360 * frac
    dice.rotate = rotation
  }
} */

    /*Make sure to add the ScalaFX library to your project dependencies.
    You can do this by adding the following lines to your build.sbt file:

    libraryDependencies += "org.scalafx" %% "scalafx" % "16.0.0-R25"*/




// Kod za igrača :

/* import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.layout.{BorderPane, HBox, Pane}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Circle

object LudoGame extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "Ludo Game"
    width = 600
    height = 400

    val player1Pawns = createPawns(Color.RED)
    val player2Pawns = createPawns(Color.BLUE)

    val pawnBox = new HBox {
      spacing = 20
      children = Seq(player1Pawns, player2Pawns)
    }

    val root = new BorderPane {
      center = pawnBox
    }

    scene = new Scene(root)
  }

  private def createPawns(color: Color): Pane = {
    val pawnSize = 30
    val pawns = (1 to 4).map { _ =>
      new Circle {
        radius = pawnSize
        fill = color
      }
    }

    new Pane {
      children = pawns
    }
  }
} */
//Path code

object Path {
  val ax: Array[Array[Int]] = Array(Array(1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6), Array(8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7), Array(13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 13, 12, 11, 10, 9, 8), Array(6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7))

  val ay: Array[Array[Int]] = Array(Array(6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7), Array(1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6), Array(8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7), Array(13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 13, 12, 11, 10, 9, 8))

  val initialx: Array[Array[Int]] = Array(Array(1, 1, 3, 3), Array(10, 10, 12, 12), Array(10, 10, 12, 12), Array(1, 1, 3, 3))

  val initialy: Array[Array[Int]] = Array(Array(1, 3, 1, 3), Array(1, 3, 1, 3), Array(10, 12, 10, 12), Array(10, 12, 10, 12))
}

//Build Player Code

class Player(height: Int, width: Int){ //Class for Player
  val pa : Array[Int] = new Array[Int](4) //New variable and constructor
  def draw(g:GraphicsContext, x: Int, y: Int, i: Int): Unit ={ } //Define a function for drawing

}

class Build_Player(height: Int, width: Int) { //Class to build Player
  val pl: Array[Player] = new Array[Player](4) // New variable and it's constructor
  for (i <- 0 until 4) {
    pl(i) = new Player(height, width)
  }
  val initialx: Array[Array[Int]] = Array(Array(1, 1, 3, 3), Array(10, 10, 12, 12), Array(10, 10, 12, 12), Array(1, 1, 3, 3))
  val initialy: Array[Array[Int]] = Array(Array(1, 3, 1, 3), Array(1, 3, 1, 3), Array(10, 12, 10, 12), Array(10, 12, 10, 12))

  def draw(g: Nothing): Unit = {
    for (i <- 0 until 4) {
      for (j <- 0 until 4) {
        pl(i).draw(g, initialx(i)(j), initialy(i)(j), i)
      }
    }
  }
}


// Layout

class Layout(gc: GraphicsContext, var x: Int, var y: Int) {
  width = 30
  height = 30
  var width = 0
  var height = 0

  def draw(g: GraphicsContext): Unit = {
    gc.setFill(Color.WHITE)
    gc.fillRect(x, y, 15 * width, 15 * height)
    gc.setStroke(Color.Black)
    for (i <- 0 until 6) {
      gc.setFill(Color.RED)
      gc.fillRect(x + (i * width), y, width, height)
      gc.fillRect(x, y + (i * height), width, height)
      gc.fillRect(x + (i * width), y + (5 * height), width, height)
      gc.fillRect(x + (5 * width), y + (i * height), width, height)
      gc.setFill(Color.GREEN)
      gc.fillRect(x + ((i + 9) * width), y, width, height)
      gc.fillRect(x + (9 * width), y + (i * height), width, height)
      gc.fillRect(x + ((i + 9) * width), y + (5 * height), width, height)
      gc.fillRect(x + (14 * width), y + (i * height), width, height)
      gc.setFill(Color.YELLOW)
      gc.fillRect(x + ((i + 9) * width), y + (9 * height), width, height)
      gc.fillRect(x + (9 * width), y + ((i + 9) * height), width, height)
      gc.fillRect(x + ((i + 9) * width), y + (14 * height), width, height)
      gc.fillRect(x + (14 * width), y + ((i + 9) * height), width, height)
      gc.setFill(Color.BLUE)
      gc.fillRect(x + (i * width), y + (9 * height), width, height)
      gc.fillRect(x, y + ((i + 9) * height), width, height)
      gc.fillRect(x + (i * width), y + (14 * height), width, height)
      gc.fillRect(x + (5 * width), y + ((i + 9) * height), width, height)
    }
    for (i <- 1 until 6) {
      gc.setFill(Color.RED)
      gc.fillRect(x + (i * width), y + (7 * height), width, height)
      gc.setFill(Color.YELLOW)
      gc.fillRect(x + ((8 + i) * width), y + (7 * height), width, height)
      gc.setFill(Color.GREEN)
      gc.fillRect(x + (7 * width), y + (i * height), width, height)
      gc.setFill(Color.BLUE)
      gc.fillRect(x + (7 * width), y + ((8 + i) * height), width, height)
    }
    gc.setFill(Color.RED)
    gc.fillRect(x + (1 * width), y + (6 * height), width, height)
    gc.setFill(Color.YELLOW)
    gc.fillRect(x + (13 * width), y + (8 * height), width, height)
    gc.setFill(Color.GREEN)
    gc.fillRect(x + (8 * width), y + (1 * height), width, height)
    gc.setFill(Color.BLUE)
    gc.fillRect(x + (6 * width), y + (13 * height), width, height)
    val temp1 = x + 45
    val temp2 = y + 45
    for (i <- 0 until 2) {
      for (j <- 0 until 2) {
        gc.setFill(Color.RED)
        gc.fillRect(temp1 + (2 * i * width), temp2 + (2 * j * height), width, height)
        gc.setFill(Color.YELLOW)
        gc.fillRect(temp1 + (2 * i * width) + 9 * width, temp2 + (2 * j * height) + 9 * height, width, height)
        gc.setFill(Color.GREEN)
        gc.fillRect(temp1 + (2 * i * width) + 9 * width, temp2 + (2 * j * height) + 0 * height, width, height)
        gc.setFill(Color.BLUE)
        gc.fillRect(temp1 + (2 * i * width) + 0 * width, temp2 + (2 * j * height) + 9 * height, width, height)
      }
    }
    gc.setFill(Color.RED)
    val xpoints0 = Array(x + (6.0 * width), x + (6.0 * width), x + 15.0 + (7.0 * width))
    val ypoints0 = Array(y + (6.0 * height), y + (9.0 * height), y + 15.0 + (7.0 * width))
    val npoints = 3
    gc.fillPolygon(xpoints0, ypoints0, npoints)
    gc.setFill(Color.YELLOW)
    val xpoints1 = Array(x + (9.0 * width), x + (9.0 * width), x + 15.0 + (7.0 * width))
    val ypoints1 = Array(y + (6.0 * height), y + (9.0 * height), y + 15.0 + (7.0 * width))
    val npoints1 = 3
    gc.fillPolygon(xpoints1, ypoints1, npoints1)
    gc.setFill(Color.GREEN)
    val xpoints2 = Array(x + (6 * width), x + (9 * width), x + 15 + (7 * width))
    val ypoints2 = Array(y + (6 * height), y + (6 * height), y + 15 + (7 * width))
    val npoints2 = 3
   /* gc.fillPolygon(xpoints2, ypoints2, npoints2)
    gc.setFill(Color.BLUE)
    val xpoints3 = Array(x + (6 * width), x + (9 * width), x + 15 + (7 * width))
    val ypoints3 = Array(y + (9 * height), y + (9 * height), y + 15 + (7 * width))
    val npoints3 = 3
    gc.fillPolygon(xpoints3, ypoints3, npoints3)
    gc.setStroke(new Font (2))
    gc.setFill(Color.BLACK)
    for (i <- 0 until 3) {
      for (j <- 0 until 6) {
        gc.strokeRect(x + ((i + 6) * width), y + (j * height), width, height)
        gc.strokeRect(x + (j * width), y + ((i + 6) * height), width, height)
        gc.strokeRect(x + ((i + 6) * width), y + ((j + 9) * height), width, height)
        gc.strokeRect(x + ((j + 9) * width), y + ((i + 6) * height), width, height)
      }
    } */
    gc.strokeRect(x + (1 * width), y + (1 * height), 4 * width, 4 * height)
    gc.strokeRect(x + (10 * width), y + (1 * height), 4 * width, 4 * height)
    gc.strokeRect(x + (1 * width), y + (10 * height), 4 * width, 4 * height)
    gc.strokeRect(x + (10 * width), y + (10 * height), 4 * width, 4 * height)
    gc.strokeRect(x, y, 15 * width, 15 * height)
    /*for (i <- 0 until 2) {
      for (j <- 0 until 2) {
        gc.strokeRect(temp1 + (2 * i * width), temp2 + (2 * j * height), width, height)
        gc.strokeRect(temp1 + (2 * i * width) + 9 * width, temp2 + (2 * j * height) + 9 * height, width, height)
        gc.strokeRect(temp1 + (2 * i * width) + 9 * width, temp2 + (2 * j * height) + 0 * height, width, height)
        gc.strokeRect(temp1 + (2 * i * width) + 0 * width, temp2 + (2 * j * height) + 9 * height, width, height)
      }
    }
    gc.fillPolygon(xpoints0, ypoints0, npoints)
    gc.fillPolygon(xpoints1, ypoints1, npoints1)
    gc.fillPolygon(xpoints2, ypoints2, npoints2)
    gc.fillPolygon(xpoints3, ypoints3, npoints3)
    gc.strokeOval(x + 5 + (6 * width), y + 5 + (2 * height), width - 10, height - 10)
    gc.strokeOval(x + 5 + (12 * width), y + 5 + (6 * height), width - 10, height - 10)
    gc.strokeOval(x + 5 + (8 * width), y + 5 + (12 * height), width - 10, height - 10)
    gc.strokeOval(x + 5 + (2 * width), y + 5 + (8 * height), width - 10, height - 10)
    gc.setFont(Font.font("serif", Font.BOLD, 40))
    gc.fillText("Player 1", 90, 35)
    gc.fillText("Player 2", 370, 35)
    gc.fillText("Player 4", 90, 540)
    gc.fillText("Player 3", 370, 540)
    gc.fillText("Instruction:", 550, 300)
    gc.fillText("1.Press enter to roll dice.", 550, 350)
    gc.fillText("2.Click on coin to move.", 550, 400)*/
  }
}

