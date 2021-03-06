package org.exoplatform.common.regex;/*
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

/**
 * Transition of a Finite State Machine
 *
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date 7/5/11
 */
public class Transition<C>
{

   private final C letter;

   private final State<C> from;

   private final State<C> to;

   public Transition(C letter, State<C> from, State<C> to)
   {
      this.letter = letter;
      this.from = from;
      this.to = to;
   }

   public C getLetter()
   {
      return this.letter;
   }

   public State<C> getTo()
   {
      return this.to;
   }

   public State<C> getFrom()
   {
      return this.from;
   }

   @Override
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Transition))
      {
         return obj == null && this == null;
      }

      Transition transition = (Transition) obj;
      return transition.letter.equals(this.letter) && transition.from == this.from && transition.to == this.to;
   }

}
