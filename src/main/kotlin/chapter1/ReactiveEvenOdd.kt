package chapter1

import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

fun main(args: Array<String>) {
    var subject: Subject<Int> = PublishSubject.create()

    subject.map({ isEven(it) }).subscribe({
        println("The number is ${(if (it) "Even" else "Odd")}")
    })
    subject.onNext(4)
    subject.onNext(9)
    subject.onComplete()
}

fun isEven(number: Int): Boolean {
    return (number % 2) == 0
}