#!/bin/bash
ansible vbox -i ../hosts -m copy -a "src=./.bashrc dest=~"
ansible vbox -i ../hosts -m copy -a "src=./.zborc dest=~"