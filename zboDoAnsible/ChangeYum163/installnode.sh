#!/bin/sh
ansible vbox -i ../hosts -m shell -a "cd ~/Downloads && wget http://nodejs.org/dist/v0.10.32/node-v0.10.32-linux-x64.tar.gz"
ansible vbox -i ../hosts -m shell -a "cd Downloads && tar -xvf node-v0.10.32-linux-x64.tar.gz"