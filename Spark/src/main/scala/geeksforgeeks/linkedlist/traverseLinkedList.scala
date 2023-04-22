package geeksforgeeks.linkedlist

object traverseLinkedList extends App {

//  val n4 = Node(50, null)
//  val n3 = Node(40, n4)
//  val n2 = Node(30, n3)
//  val n1 = Node(20, n2)
//  val head: Node = Node(10, n1)

  //var head:Option[Node] = None //Initialized as None and will be considered as next node going ahead
  var head = Some(Node(10, None))
  val node2 = Some(Node(20, None))
  head.get.next = node2

  println(head)

  def printLinkedList(node:Option[Node]):Unit={
    var head = node
    if (node == None){
      println(s"LL is empty.")
    }else{
      while(head!=None){
        println(head.get.value)
        head = head.get.next
      }
    }
  }

  printLinkedList(head)

}