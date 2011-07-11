/*
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.common.regex.grammar.model;

import java.util.LinkedList;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date 7/11/11
 */
public abstract class ASTTree
{

   private Entry root;

   private LinkedList<Entry> children;

   static class Entry{

      private Symbol symbol;

      private Entry left;

      private Entry right;

      public Entry(Symbol symbol)
      {
         this(symbol, null, null);
      }

      public Entry(Symbol symbol, Entry left, Entry right)
      {
         this.symbol = symbol;
         this.left = left;
         this.right = right;
      }

      public Entry getLeft()
      {
         return left;
      }

      public Entry getRight()
      {
         return right;
      }

      public Symbol getSymbol()
      {
         return symbol;
      }
   }

}
