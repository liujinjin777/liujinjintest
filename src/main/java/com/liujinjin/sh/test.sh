#!/usr/bin/env bash


# 学习资料 https://github.com/qinjx/30min_guides/blob/master/shell.md
# 拼接字符串
your_name="qinjx"
greeting="hello, "$your_name" !"
greeting_1="hello, ${your_name} !"
echo $greeting
echo $greeting_1