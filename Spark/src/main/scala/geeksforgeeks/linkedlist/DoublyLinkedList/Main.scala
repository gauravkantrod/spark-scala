package geeksforgeeks.linkedlist.DoublyLinkedList

object Main extends App {
  val doublyList = DoublyLinkedList()

  doublyList.append(10)
  doublyList.append(99)
  doublyList.append(89)
  doublyList.append(39)

  doublyList.addElementAtStart(76)

  println(doublyList)
  doublyList.printDoublyLinkedList()
}