package geeksforgeeks.linkedlist.circularLinkedList

case class CircularLinkedList(var head:Option[Node]=None, var tail:Option[Node]=None){

  def addNode(value:Int):Unit={
    if(head.isEmpty){
      head = Some(Node(value))
      tail = head
      head.get.next = head
    }else{
      //newNode.get.next = head
    }
  }

}