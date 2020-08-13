# rabbitmq-spring-cloud-stream
rabbitmq project using spring cloud stream

## Steps to go throgh codes.

### Step-1.
go to build.gradle file to manage dependencies.

### Step-2.
go through property file to insert properties important for RabbitMQ.
for Exchange/Channel = Output
for Queue = Input

### Step-3.
go through RabbitMessageSource interface.
@Output annotation is used to create Exchange/Channel.
@Input annotation is used to create Queue.

### Step-3.
go through MessagePayload model to create message payload that we want to send into RabbitMQ.

Note- I have used Lombok annotations to make my code neet and clean.

### Step-4.
go through MessageController to create controller endpoint.

### Step-5.
go through MessageService where i have written business logic to send message payload to RabbitMQ.


### Step-6.
go through MessageListener, in this we have used an annotation @StreamListener to create our lisener.
This listener can read messages from RabbitMQ and we can verify.

