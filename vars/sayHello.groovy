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
}
