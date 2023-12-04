package cn.waltersun

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties


val x = 1
fun main() {
    var a = 1
    var b = 2
    a = b.also { b = a }
    println("a=$a,b=$b")

    println(::x.get())
    println(::x.name)

    // 反射
    // 获取类信息
    val clazz = MyClass::class // 获取类的KClass对象
    val className = clazz.simpleName // 获取类的简单名称
    val packagePath = clazz.qualifiedName // 获取类的完整路径

    // 实例化对象
    val obj = clazz.createInstance() // 实例化对象
    println(obj)

    // 访问属性
    val property = clazz.memberProperties.find { it.name == "propertyName" } // 获取属性
    val value = property?.get(obj) // 获取属性值
    println(value)
//    property.set(obj, "newValue") // 设置属性值

    // 调用方法
    val method = clazz.memberFunctions.find { it.name == "methodName" } // 获取方法
    val result = method?.call(obj, "arg1", "arg2") // 调用方法，并传递参数


}

