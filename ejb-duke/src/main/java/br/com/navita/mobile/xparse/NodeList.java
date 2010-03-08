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
 * $Id: JSArray.java,v 1.1 2000/04/03 07:43:37 classen Exp $
 */

package br.com.navita.mobile.xparse;

import java.util.Hashtable;
import java.util.Vector;

/**
 * Mimics a Javascript array;
 * not completely generic because only specific properties are allowed
 * <p>would need Reflection to make it completely generic
 *
 * @author    Michael Cla�en
 * @version   $Revision: 1.1 $
 */
public class NodeList {

  // underlying element holder
  @SuppressWarnings("unchecked")
private Vector worker = new Vector();

  // constants for the currently supported object properties
  static final String Name = "name";
  static final String Attributes = "attributes";
  static final String Contents = "contents";
  static final String Value = "value";

  /**
   * gets the object with a certain index
   *
   * @param     idx the object's index in the array
   * @return    Object at the respective index
   */
  public Object elementAt(int idx) {
	  if(worker.size()==0){
		  return null;
	  }
    return worker.elementAt(idx);
  }

  /**
   * sets the object with a certain index
   *
   * @param     val the object to be set in the array
   * @param     idx the object's index in the array
   */
  @SuppressWarnings("unchecked")
void setElementAt(Object val, int idx) {
    worker.insertElementAt(val, idx);
  }

  /**
   * sets the object with a certain index
   *
   * @param     val the object' property to be set
   * @param     idx the object's index in the array
   * @param     prop the name of the object's property to be set;
   *            currently can only be: name, attributes, contents, value
   */
  @SuppressWarnings("unchecked")
void setElementAt(Object val, int idx, String prop) {
    Node n = (Node) worker.elementAt(idx);
    if (prop == Name) {
      n.name = (String) val;
    }
    else if (prop == Attributes) {
      n.attributes = (Hashtable) val;
    }
    else if (prop == Contents) {
      n.contents = (NodeList) val;
    }
    else if (prop == Value) {
      n.value = (String) val;
    }
  }

  /**
   * returns the length / size of the array
   *
   * @return    the array length
   */
  public int length() {
    return worker.size();
  }

  /**
   * splits a string into an array of strings, broken at a distinct separator
   *
   * @param     str the String to be split
   * @param     sep the seperator at which to split
   */
  @SuppressWarnings("unchecked")
void split(String str, String sep) {
    worker.removeAllElements();
    int oldidx = 0, newidx, skip = sep.length();
    while((newidx = str.indexOf(sep, oldidx)) != -1) {
      worker.addElement(str.substring(oldidx, newidx));
      oldidx = newidx + skip;
    }
    worker.addElement(str.substring(oldidx));
  }

  /**
   * join this array into one string delimited by a separator
   *
   * @param     sep the seperator to put in between the array elements
   * @return    the joined String
   */
  String join(String sep) {
    int no = 0;
    StringBuffer sb = new StringBuffer();
    while (no < worker.size()) {
      sb.append(worker.elementAt(no));
      if (++no < worker.size()) sb.append(sep);
    }
    return sb.toString();
  }

}
