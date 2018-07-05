#! /bin/bash

## 资源库同步
project_path=/webapp/source/vueAdmin-template
cd $project_path
pwd=$(pwd)
echo "切换到git文件夹："$pwd
echo "准备git同步"
git_pull=$(git pull)
echo "同步结果："$git_pull

## npm build
echo "准备构建编译"
npm_install=$(npm i)
echo "npm install:"$npm_install
npm_build=$(npm run build)
echo "构建结果："$npm_build
