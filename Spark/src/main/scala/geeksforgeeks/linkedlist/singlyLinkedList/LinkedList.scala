package geeksforgeeks.linkedlist.singlyLinkedList

object LinkedList extends App {

  def printLinkedList(node: Option[Node]): Unit = {
    var head = node
    if (node == None) {
      println(s"LinkedList is empty.")
    } else {
      while (head != None) {
        println(head.get.value)
        head = head.get.next
      }
    }
  }

  def addElementAtLast(value: Int): Unit = {
    if (head.isEmpty) {
      head = Some(Node(value))
    }
    else {
      var currentNode = head
      while (currentNode.get.next.isDefined) {
        currentNode = currentNode.get.next
      }
      currentNode.get.next = Some(Node(value))
    }
  }

  def addElementAtStart(value: Int): Unit = {
    val node = Some(Node(value))
    node.get.next = head
    head = node
  }

  def removeFirstNode(): Unit = {
    if (head.isEmpty) {
      println(s"List is empty")
    } else {
      head = head.get.next
    }
  }

  def removeLastNode(): Unit = {
    if (head.isEmpty) {
      println(s"List is empty")
    } else {
      var previousNode: Option[Node] = None
      var currentNode = head
      while (currentNode.get.next.isDefined) {
        previousNode = currentNode
        currentNode = currentNode.get.next
      }
      if (previousNode.get.next.isDefined) {
        previousNode.get.next = None
      } else {
        head = None
      }

    }
  }

  def removeInBetweenNode(value: Int): Unit = {
    var isRemoved = false
    if (head.isEmpty) {
      println(s"List is empty.")
    } else {
      var currentNode = head
      var previousNode: Option[Node] = None
      var nextNode: Option[Node] = None

      while (currentNode.get.next.isDefined) {
        previousNode = currentNode
        currentNode = currentNode.get.next
        nextNode = currentNode.get.next

        if (currentNode.get.value == value) {
          previousNode.get.next = nextNode
          isRemoved = true
        } else {
          previousNode = currentNode
        }
      }
    }

    if (!isRemoved) {
      println(s"In between node not found.")
    }
  }

  var head = Option(Node(10))
  addElementAtLast(99)
  addElementAtLast(29)
  addElementAtStart(1)
  addElementAtStart(909)
  printLinkedList(head)

  println("******************************")
  //removeFirstNode()
  removeInBetweenNode(29)
  //removeLastNode()
  removeInBetweenNode(1)
  printLinkedList(head)
}
