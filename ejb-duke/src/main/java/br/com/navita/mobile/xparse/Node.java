/* Copyright (c) 2000 Michael Cla�en <mclassen@internet.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * $Id: Node.java,v 1.2 2001/01/05 19:32:05 classen Exp $
 */

package br.com.navita.mobile.xparse;

import java.util.Hashtable;

/**
 * A node of an XML DOM tree;
 *
 * @author    Michael Cla�en
 * @version   $Revision: 1.2 $
 */
public class Node {

	public String type;
	public String name;
	public String value;
	public Hashtable<Node,String> attributes;
	public int uid;
	public NodeList contents;
	public NodeList index;

	public NodeList getChildNodes(){
		return contents;
	}

	public String getChildValue(String tagName) {
		Node tag=find(tagName, new int[]{1});
		if(tag==null){
			return null;
		}
		return tag.getCharacters();

	}

	// node types
	static final String Element = "element";
	static final String CharData = "chardata";
	static final String PI = "pi";
	static final String Comment = "comment";

/////////////////////////
////	the object constructors for the hybrid DOM

	/**
	 * factory method for element nodes
	 *
	 * @return    a Node of type element
	 */
	static Node createElement() {
		Node n = new Node();
		n.type = Element;
		n.name = "";
		n.attributes = new Hashtable<Node,String>();
		n.contents = new NodeList();
		n.uid = Xparse.count++;
		Xparse.index.setElementAt(n, n.uid);
		return n;
	}

	/**
	 * factory method for the root element
	 *
	 * @return    a rootelement Node
	 */
	static Node createRootelement() {
		return createElement();
	}

	/**
	 * factory method for chardata nodes
	 *
	 * @return    a chardata Node
	 */
	static Node createChardata() {
		Node n = new Node();
		n.type = CharData;
		n.value = "";
		return n;
	}

	/**
	 * factory method for PI nodes
	 *
	 * @return    a PI Node
	 */
	static Node createPi() {
		Node n = new Node();
		n.type = PI;
		n.value = "";
		return n;
	}

	/**
	 * factory method for comment nodes
	 *
	 * @return    a comment Node
	 */
	static Node createComment()
	{
		Node n = new Node();
		n.type = Comment;
		n.value = "";
		return n;
	}

	/**
	 * returns the character data in the first child element;
	 * returns nonsense if the first child element ist not chardata
	 *
	 * @return    the characters following an element
	 */
	public String getCharacters() {
		if(contents == null || contents.length()==0){
			return null;
		}
		return ((Node)contents.elementAt(0)).value;
	}

	/**
	 * find the node matching a certain occurrence of the path description
	 *
	 * @param     path an XPath style expression without leading slash
	 * @param     occur array indicating the n'th occurrence of a node matching each simple path expression
	 *
	 * @return    the n'th Node matching the path description
	 */
	public Node find(String path, int[] occur) {
		Node n = this;
		NodeList a = new NodeList();
		a.split(path, "/");
		int xx = 0;
		while (xx < a.length()) {
			n = findChildElement(n, (String)a.elementAt(xx), occur[xx]);
			if (n == null) return null;
			xx++;
		}
		return n;
	}

	/**
	 * find the child node matching a certain occurrence of a simple path description
	 *
	 * @param     parent the parent node to start from
	 * @param     simplePath one element of an XPath style expression
	 * @param     occur the n'th occurance of a node matching the path expression
	 *
	 * @return    the n'th child Node matching the simple path description
	 */
	Node findChildElement(Node parent, String simplePath, int occur) {
		NodeList a = parent.contents;
		Node n;
		int  found = 0;
		int i = 0;
		String tag;
		do {
			n = (Node)a.elementAt(i);
			if(n==null) continue;
			++i;
			tag = (n.name != null) ? n.name : "";
			int colonPos = tag.indexOf(':');
			tag = (colonPos == -1) ? tag : tag.substring(colonPos + 1);
			if (simplePath.equals(tag)) ++found;
		} while (i < a.length() && found < occur);
		return (found == occur) ? n : null;
	}

}

