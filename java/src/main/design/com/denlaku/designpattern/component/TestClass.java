package com.denlaku.designpattern.component;

import com.denlaku.designpattern.component.ComponentDemo.Composite;
import com.denlaku.designpattern.component.ComponentDemo.Leaf;

public class TestClass {
	public static void main(String[] args) {
		ComponentDemo demo = new ComponentDemo();
		// 构造根节点
		Composite rootComposite = demo.new Composite();
		rootComposite.name = "根节点";

		// 左节点
		Composite compositeLeft = demo.new Composite();
		compositeLeft.name = "左节点";

		// 构建右节点，添加两个叶子几点，也就是子部件
		Composite compositeRight = demo.new Composite();
		compositeRight.name = "右节点";
		Leaf leaf1 = demo.new Leaf();
		leaf1.name = "右-子节点1";
		Leaf leaf2 = demo.new Leaf();
		leaf2.name = "右-子节点2";
		compositeRight.add(leaf1);
		compositeRight.add(leaf2);

		// 左右节点加入 根节点
		rootComposite.add(compositeRight);
		rootComposite.add(compositeLeft);
		// 遍历组合部件
		rootComposite.eachChild();
	}
}
