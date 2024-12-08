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

  script {
        sh '''
            for node in "172.24.9.99 172.24.9.75"
            do
                echo $node
            done

        '''
  }

}
