#!/usr/bin/env groovy
def call(String name = 'human') {
  echo "Hello, ${name}."

  parallel(
        a: {
          echo "This is branch a"
        },
        b: {
          echo "This is branch b"
        },
        c: {
          echo "This is branch c"
        }
  )

  def nodes = "172.24.9.99 172.24.9.75".split(" ")

  def serverVersionList = "1234134 24124 134234".split(" ")

  println nodes

  def list = [1,2,3,4]
  for(item in list){
      println item
  }

  def func = [:]


  // 先并行，再串行
  nodes.each { k ->
        func[k] = {
            for (server in serverVersionList) {
                sh label: 'echo', script: """
                    echo ${k} ${server}
                """
            }
        }
  }

  parallel func
}
