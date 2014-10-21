#!/bin/sh
ansible vbox -i ../hosts -m shell -a "rm -rf ~/163.repo"
ansible vbox -i ../hosts -m shell -a "mkdir ~/163.repo"
ansible vbox -i ../hosts -m copy -a "src=./CentOS-Base-163.repo dest=~/163.repo"
ansible vbox -i ../hosts -m shell -a "cp ~/163.repo/CentOS-Base-163.repo . && cd ~"



