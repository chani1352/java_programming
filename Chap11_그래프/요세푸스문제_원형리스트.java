package Chap11_그래프;

import java.util.Random;
import java.util.Scanner;

	class Node10{
		int id;
		Node10 link;
		
		public Node10(int id) {
			this.id = id;
			link = this;
		}
		
		@Override
		public String toString() {
			return "아이디 정보 : " + id;
		}
	}
	
	class LinkedList10 {
		Node10 first;
		
		public LinkedList10() {
			first = new Node10(0);
			first.link = first;
		}
		
		
		
		public void Show() { // 전체 리스트를 순서대로 출력한다.
			Node10 p = first.link;
			while(true) {
				if(p != first) {
					System.out.println(p.toString());
					p = p.link;
				} else break;
			}

		}
		
		public int Delete(int count) {
			Node10 q,current = first.link;
			q = current;
			
			while(true) {
				for(int i = 0;  i < count-1 ; i++) {
					q= current;
					current = current.link;
					if(current == first) {
						current = current.link;
					}
				}
				current = current.link;
				q.link = current;
				if(current == first) {
					current = current.link;
				}
				if(current.link == first && first.link == current) break;

			}
			
			
			while(true) {
				if(current != first) {
					System.out.println(current.toString());
					current = current.link;
				} else break;
			}
			
			return first.link.id;		
		}
		
		public void Add(int id) {
			Node10 newNode = new Node10(id);
			if(first.link == first) {
				first.link = newNode;
				newNode.link = first;
				return;
			}
			Node10 p = first.link;
			Node10 q = first;
			
			while(true) {
				if(id > p.id) {
					q = p;
					p = p.link;
					if(p == first) {
						q.link = newNode;
						newNode.link = first;
						break;
					}
				}else {
					q.link = newNode;
					newNode.link = p;
					break;
				}
			}
		}	
	}
	
	public class 요세푸스문제_원형리스트 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		LinkedList10 list = new LinkedList10();

		
		System.out.print("사람의 수를 입력하세요. : ");
		int num = sc.nextInt();
		
		int[] input = new int[num];
	
		for(int i = 0 ; i < num ; i++) {
			int rn = rand.nextInt(50);
			list.Add(rn);
//			System.out.println(rn);
		}
		
		list.Show();
		
		System.out.print("제거할 사람의 순서를 입력하세요. : ");
		int count = sc.nextInt();
		System.out.println(list.Delete(count));
		
	}


}
