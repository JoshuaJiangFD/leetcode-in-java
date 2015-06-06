package joshua.leetcode.segmenttree;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class SegmentTree {

	private  static final Function sumFunc = new Function() {
		@Override
		public STNode apply(STNode x, STNode y) {
			return new STNode(x.value+y.value,Math.min(x.startIdx, y.startIdx),Math.max(x.endIdx, y.endIdx));
		}
	};

	private static final Function minFunc = new Function() {
		@Override
		public STNode apply(STNode x, STNode y) {
			int index=x.value<y.value?x.index:y.index;
			return new STNode(Math.min(x.value, y.value),index,Math.min(x.startIdx, y.startIdx),Math.max(x.endIdx, y.endIdx));
		}
	};

	public static enum FunctionType{
		Min,Sum
	}
	
	STNode[] st;
	int[] originalArr;
	int length;
	Function funct;
	FunctionType funcType;

	public SegmentTree(int[] arr,FunctionType funcType) {
		originalArr = arr;
		length = arr.length;
		this.funcType=funcType;
		this.funct=getFunction(this.funcType);
		st = constructST(arr, this.funct);
	}

	public SegmentTree(List<Integer> list,FunctionType funcType){
		this(ArrayUtils.toPrimitive(list.toArray(new Integer[list.size()])),funcType);
	}
	
	private Function getFunction(FunctionType type){
		switch(type){
		case Min:
			return this.minFunc;
		case Sum:
			return this.sumFunc;
		default:
				throw new IllegalArgumentException("unsupported function type.");
		}
	}
		
	/**
	 * calculate sum of elements ranging from index qStart to qEnd.
	 * @param qStart
	 * @param qEnd
	 * @return
	 */
	public STNode applyRange(int qStart, int qEnd) {
		if (qStart < 0 || qEnd > length - 1 || qStart > qEnd)
			throw new IllegalArgumentException("Illeage Argument qStart,qEnd");
		return recursivelyApplyRange(qStart, qEnd, 0, this.length - 1, 0);
	}

	/**
	 * recursive function to get sum of range[qStart,qEnd].
	 * @param qStart start of querying range in array.
	 * @param qEnd end of querying range in array.
	 * @param stStart the starting index of the segment represented by current node, i.e. st[curPos]
	 * @param stEnd
	 * @param curPos index of current node in the segment tree. initially is 0 as the root index is 0
	 * @return
	 */
	public STNode recursivelyApplyRange(int qStart, int qEnd, int stStart,
			int stEnd, int curPos) {
		/*if segment of current node is outside of the query range*/
		if (qStart > stEnd || qEnd < stStart){
			switch(this.funcType){
			case Min:
				return new STNode(Integer.MAX_VALUE,-1,qStart,qEnd);
			case Sum:
				return new STNode(0,qStart,qEnd);
			default:
				throw new IllegalArgumentException("unsupported argument exception");
			}
		}
		/*if query range fully covers the segment of current node*/
		if (qStart <= stStart && qEnd >= stEnd)
			return st[curPos];
		/*two range overlaps, split the calculation*/
		int mid = (stStart + stEnd) / 2;
		STNode leftRes = recursivelyApplyRange(qStart, qEnd, stStart, mid,
				curPos * 2 + 1);
		STNode rightRes = recursivelyApplyRange(qStart, qEnd, mid + 1, stEnd,
				curPos * 2 + 2);
		return this.funct.apply(leftRes, rightRes);
	}

	/**
	 * construct a segment tree using input {@code arr}
	 * @param arr
	 * @return
	 */
	public STNode[] constructST(int[] arr, Function func) {
		/**
		 * calculate the size of the segment tree for n-size array: A(n)
		 * A segment tree is modeled as full binary tree with 2*n-1 nodes, within which n leaf nodes and n-1 non-leaf nodes.
		 * All leaf nodes are the original elements in A(n)
		 * All non-leaf nodes are the calculated node containing the value of function applied on all leaf nodes under each.
		 * A segment tree is stored in array, combined with the nature of full binary tree, we deduce that:
		 * If number all nodes by level from top to bottom starting from 0.
		 * for node with index i, the left child's index is 2*i+1, the right child 2*i+2;
		 * for node with index i, its parent node's index is floor[(i-1)/2];
		 * the size of the segment tree is calculated as follow.
		 */
		int x = (int) Math.ceil(Math.log(arr.length) / Math.log(2));/*the height of segment tree, root has height as 0*/
		int max_size = 2 * (int) Math.pow(2, x) - 1;/*the maximum size of the segment tree*/
		STNode[] st = new STNode[max_size];
		recursivelyConstruct(arr, st, 0, arr.length - 1, 0, func);
		return st;
	}

	/**
	 * recursively build the segment tree, in each recursion, calculate the value on range from {@code rangeStart}
	 * to {@code rangeEnd} of array {@code arr} by applying {@code func}.
	 * the value will be stored to {@code curPos} of segment tree {@code st}
	 * @param arr
	 * @param st
	 * @param rangeStart
	 * @param rangeEnd
	 * @param curPos
	 * @param func
	 * @return
	 */
	public  STNode recursivelyConstruct(int[] arr, STNode[] st, int rangeStart,
			int rangeEnd, int curPos, Function func) {
		if (rangeStart == rangeEnd) {
			switch (this.funcType){
			case Min:
				st[curPos]= new STNode(arr[rangeStart],rangeStart,rangeStart,rangeEnd);
				break;
			case Sum:
				st[curPos]= new STNode(arr[rangeStart],rangeStart,rangeEnd);
				break;
			}
			return st[curPos];
		}
		int mid = (rangeStart + rangeEnd) / 2;
		STNode leftRes = recursivelyConstruct(arr, st, rangeStart, mid,
				curPos * 2 + 1, func);
		STNode rightRes = recursivelyConstruct(arr, st, mid + 1, rangeEnd,
				curPos * 2 + 2, func);
		st[curPos] = func.apply(leftRes, rightRes);
		return st[curPos];
	}

	static interface Function {
		STNode apply(STNode x, STNode y);
	}
	

	public static class STNode{
		public int value;
		public int index;/*for FunctionType.Min: the index of value in original array*/
		public int startIdx;
		public int endIdx;
		
		public STNode(int value,int index,int startIdx,int endIdx){
			this.value=value;
			this.index=index;
			this.startIdx=startIdx;
			this.endIdx=endIdx;
		}
		public STNode(int value,int startIdx,int endIdx){
			this.value=value;
			this.startIdx=startIdx;
			this.endIdx=endIdx;
		}
		@Override
		public String toString() {
			return "STNode [value=" + value + ", index=" + index
					+ ", startIdx=" + startIdx + ", endIdx=" + endIdx + "]";
		}
		
		
	}
}
