#!/usr/bin/env groovy
def call(String name = 'human') {
  echo "Hello, ${name}."

  parallel(
        a: {
          echo "This is branch a"
        },
        b: {
          echo "This is branch b"
        }
  )

  def nodes = "172.24.9.99 172.24.9.75".split(" ")

  println nodes

  nodes.each { node ->
        sh '''
            echo ${node}
        '''

  }
}
