Feature: Register DDT

  Background: 
    Given user clicks on signup_login option on homepage

  Scenario Outline: Register User DTT
    
    Then verify user registration based on the account details "<username>" "<emailaddress>" "<status>" "<title>" "<password>" "<day>" "<month>" "<year>" "<fname>" "<lname>" "<company>" "<address1>" "<address2>" "<country>" "<state>" "<city>" "<zip>" "<mobile>"

    Examples: 
      | username    | emailaddress                 | status               | title | password      | day | month | year | fname | lname | company | address1   | address2  | country       | state     | city    | zip    | mobile     |
      |             | jason@gmail.com              | noname               |       |               |     |       |      |       |       |         |            |           |               |           |         |        |            |
      | jhonny      |                              | noemail              |       |               |     |       |      |       |       |         |            |           |               |           |         |        |            |
      |             |                              | nonameandemail       |       |               |     |       |      |       |       |         |            |           |               |           |         |        |            |
      | jacksonhole | jacksonholefinal13@gmail.com | validallfields       | Mr.   | Password12345 |  12 |     3 | 1993 | Sonia | Bajaj | Dell    | Behind the | Above the | Canada        | Ottawa    | Toronto | 512364 | 1023654789 |
      | vegas       | vegarome                     | invalidemailformat   |       |               |     |       |      |       |       |         |            |           |               |           |         |        |            |
      | framework   | framework@gmail.com          | existinguser         |       |               |     |       |      |       |       |         |            |           |               |           |         |        |            |
      | jhonny      | jhonnyplayerandom@gmail.com  | validmandatoryfields |       | HelloIamfine  |     |       |      | Ramu  | Kaka  |         | Above thhe |           | Australia     | Kerala    | Hampi   | 541298 | 3654128795 |
      | ramson      | ramson@gmail.com             | validwithoutpassword |       |               |     |       |      | Ramu  | Kaka  |         | Abobve the |           | United States | Rajasthan | Hospet  | 412578 | 9845236170 |
      | ramson      | ramson@gmail.com             | validwithoutfname    |       | hleoojk12     |     |       |      |       | Kaka  |         | Abobve the |           | India         | Koppal    | Hospet  | 412578 | 9845236170 |
      | ramson      | ramson@gmail.com             | validwithoutlname    |       | hleoojk13     |     |       |      | Ramu  |       |         | Abobve the |           | Canada        | Koppal    | Hospet  | 412578 | 9845236170 |
      | ramson      | ramson@gmail.com             | validwithoutaddress1 |       | hleoojk14     |     |       |      | Ramu  | Kaka  |         |            |           | India         | Koppal    | Hospet  | 412578 | 9845236170 |
      | ramson      | ramson@gmail.com             | validwithoutstate    |       | hleoojk15     |     |       |      | Ramu  | Kaka  |         | Abobve the |           | Canada        |           | Hospet  | 412578 | 9845236170 |
      | ramson      | ramson@gmail.com             | validwithoutcity     |       | hleoojk16     |     |       |      | Ramu  | Kaka  |         | Abobve the |           | India         | Koppal    |         | 748321 | 1245789335 |
      | ramson      | ramson@gmail.com             | validwithoutzip      |       | hleoojk17     |     |       |      | Ramu  | Kaka  |         | Abobve the |           | India         | Koppal    | Hampi   |        | 1245789335 |
      | ramson      | ramson@gmail.com             | validempty           |       |               |     |       |      |       |       |         |            |           |               |           |         |        |            |
      | ramson      | ramson@gmail.com             | validwithoutphone    |       | hleoojk19     |     |       |      | Ramu  | Kaka  |         | Abobve the |           | India         | Koppal    | Hampi   | 748321 |            |
