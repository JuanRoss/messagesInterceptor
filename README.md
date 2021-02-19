# messagesInterceptor
Udp server and parser for grouping request-response messages in big sets of data

The simulated protocol has the next format:
network-headers(transport-headers(application-packet)))

The data is received as ascii characters.

Network protocol:
-----------------
- Origin ip: 3 character
- Destination ip: 3 character
- Body length: Variable length (number in ascii representation)
- Body: The nested transport packet

Transport protocol:
-------------------
- Origin port: 1 character
- Destination port: 1 character
- Body length: Variable length (number in ascii representation)
- Body: The neste application packet

Application protocol:
---------------------
- Number of operations: 1 character
- Math operator: 1 character (+,-,*,/,=)
- Operands: Length variable (Format: [operand1#operand2]) (Using the character * as operand means using the result of the previous operation) (= operations always has - as second operand)

Example:
-------
ABCXYZ18#ui13#2+[2#2]-[*#3]

Considerations:
---------------
- The frames received could contain several request and responses, but request are always received "before" than answers in the packages.
- Sometimes the response could be received in the subsequent frame of the frame that contains the request. If response isn't found in that frame, application assumes than response is lost.
