# Ѓорѓи Камчев 215027
![Untitled Diagram drawio](https://github.com/FinalGetsuga/SI_2024_lab2_215027/assets/121571223/d329f7d7-682b-452f-a387-43263cd8e827)
M = [Number of decision points] + 1 => M = 9 + 1 = 10<br>
Бидејќи е една единствена функција може да се искористи ова решение.Во нашиов код имаме 7 if decision points и 2 for decision points па така
цикломатската комплексност на дадениот код изнесува 10. 

Test Case 1: Input: allItems = null payment = 100 Result: allItems list can't be null!<br>
Доколку за листата внесеме null,како резултат се добива првиот исклучок.

Test Case 2: Input: allItems = [] payment = 100 Result: true<br>
Доколку не сме внесиле ништо за листата, како резултат се добива "true" бидејќи листата е празна.

Test Case 3: Input: allItems = [new Item(null, "12345", 100, 0.1f)] payment = 100 Result: true<br>
Доколку за името имаме внесено null, како резултат се добива "true".

Test Case 4: Input: allItems = [new Item("", "12345", 100, 0.1f)] payment = 100 Result: true<br>
Доколку за името немаме внесено ништо, како резултат се добива "true".

Test Case 5: Input: allItems = [new Item("item1", null, 100, 0.1f)] payment = 100 Result: No barcode!<br>
Доколку за баркодот имаме внесено null вредност, како резултат се фрла исклучок.

Test Case 6: Input: allItems = [new Item("item1", "1a23b", 100, 0.1f)] payment = 100 Result: Invalid character in item barcode!<br>
Доколку во баркодот внесеме знаци кои што не се броеви, како резултат се фрла исклучок.

Multiple Condition

Test Case 1: F-F-F Input: allItems = [new Item("item1", "112345", 200, 0.0f)] payment = 380 Result: true<br>
Во овој случај сите услови се не точни, па така цената останува иста.Во овој случај цената е 200 што е помала од
payment и како резултат се добива "true".

Test Case 2: F-F-T Input: allItems = [new Item("item1", "012345", 200, 0.0f)] payment = 380 Result: true<br>
Во овој случај првите два услови се не точни а последниот услов за баркод е точен.Но бидејќи имаме локичко "И" помеѓу
условите, повторно sum -= 30 не се извршува што значи цената останува иста.Во овој случај цената е 200 што е помала од
payment и како резултат се добива "true".

Test Case 3: F-T-F Input: allItems = [new Item("item1", "112345", 200, 0.1f)] payment = 380 Result: true<br>
Во овој случај првиот и третиот услов се неточни а вториот услов е точен.Бидејќи имаме попуст цената ќе биде помножена 
по тој попуст, но бидејќи логичкото "И" sum -= 30 нема да се изврши што значи цената останува иста.Во овој случај добиената
нова цена е помала од payment и како резултат се добива "true".

Test Case 4: F-T-T Input: allItems = [new Item("item1", "012345", 200, 0.1f)] payment = 380 Result: true<br>
Во овој случај првиот услов е не точен а вториот и третиот услов се точни. Имаме попуст што значи цената се помножува по 
тој попуст, но цената останува иста поради логичкото "И".Во овој случај добиената
нова цена е помала од payment и како резултат се добива "true".

Test Case 5: T-F-F Input: allItems = [new Item("item1", "112345", 320, 0.0f)] payment = 380 Result: true<br>
Во овој случај само првиот услов е точен а другите два не точни.Цената 320 е помала од payment па така како резултат се
добива "true".

Test Case 6: T-F-T Input: allItems = [new Item("item1", "012345", 320, 0.0f)] payment = 380 Result: true<br>
Во овој случај првиот и третиот услов се точни а вториот не точен.Не се извшува sum -= 30, цената останува иста.
Цената 320 е помала од payment па така како резултат се добива "true".

Test Case 7: T-T-F Input: allItems = [new Item("item1", "112345", 320, 0.2f)] payment = 380 Result: true<br>
Во овој случај првите два услови се точни а последниот/третиот услов е не точен.Имаме попуст што значи цената се помножува
по тој попуст. Бидејќи логичкото "И", sum -= 30 не се извршува па така ново добиената цена е помала од payment и како резултат
се добива "true".

Test Case 8: T-T-T Input: allItems = [new Item("item1", "012345", 320, 0.2f)] payment = 380 Result: true
Во овој случај сите услови се точни. Имаме попуст па така цената се помножува со тој попуст. Бидејќи сите услови се точни се извршува и
sum -= 30 па така ново добиената цена е помала од payment и како резултат се добива "true".
