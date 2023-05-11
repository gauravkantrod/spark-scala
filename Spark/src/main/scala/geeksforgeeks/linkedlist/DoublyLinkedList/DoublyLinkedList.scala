package geeksforgeeks.linkedlist.DoublyLinkedList

case class DoublyLinkedList(var head:Option[Node]=None, var tail:Option[Node]=None){

  def append(value:Int):Unit = {
    val newNode = Some(Node(value))
    if(head.isEmpty){
      head = newNode
      tail = newNode
    }else{
      tail.get.next = newNode
      tail = newNode
    }
  }

  def addElementAtStart(value:Int):Unit={
    val newNode = Some(Node(value))
    if(head.isEmpty){
      head = newNode
      tail = newNode
    }else{
      newNode.get.next = head
      head = newNode
    }
  }

//  def addElementAtIndex(value:Int, index:Int):Unit={
//    val newNode = Some(Node(value))
//
//    if (head.isEmpty){
//      println("Empty linked list.")
//    }
//
//  }

  def printDoublyLinkedList():Unit={
    while(head.get.next.isDefined){
      println(head.get.value)
      head = head.get.next
    }
  }

}