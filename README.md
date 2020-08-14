# rabbitmq-spring-cloud-stream
rabbitmq project using spring cloud stream

## Steps to go through codes.

### Step-1.
go to build.gradle file to manage dependencies.

### Step-2.
go through property file to insert properties important for RabbitMQ.
for Exchange/Channel = Output. 
for Queue = Input.

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

### Dependencies for Build.gradle
//lombok dependency
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
	
	//swagger dependency
	compile group: 'io.springfox', name: 'springfox-swagger-ui', version: '3.0.0'
	implementation "io.springfox:springfox-boot-starter:3.0.0"
	
	//rabbitmq dependency
	compile group: 'org.springframework.cloud', name: 'spring-cloud-starter-stream-rabbit', version: '3.0.3.RELEASE'
	
	//Easy Random Framework dependency
	testImplementation('org.jeasy:easy-random-core:4.2.0')
	compile("com.cah.chh.ep:easy-random-framework:1.0.0")
