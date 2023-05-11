package geeksforgeeks.linkedlist.circularLinkedList

case class CircularLinkedList(var head:Option[Node]=None, var tail:Option[Node]=None){

  def addNode(value:Int):Unit={
    val newNode = Some(Node(value))
    if(head.isEmpty){
      head = newNode
      //tail = newNode
      head.get.next = head
    }else{
//      head.get.next = newNode
//      tail = newNode
//      newNode.get.next = head
    }
  }

}