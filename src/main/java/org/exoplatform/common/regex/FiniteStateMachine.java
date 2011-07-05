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

import java.util.Set;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date 7/5/11
 */
public class FiniteStateMachine
{

   private final State startState;

   private State currentState;

   public FiniteStateMachine(State startState)
   {
      this.startState = startState;
      this.currentState = startState;
   }

   public boolean accept(CharSequence charSequence)
   {
      int index =0;

      for(; index < charSequence.length(); index++)
      {
         char c = charSequence.charAt(index);
         State to = currentState.findTargetState(c);

         if(to == null)
         {
            return false;
         }
         else if(to.isFinal())
         {
            return true;
         }
         else
         {
            currentState = to;
         }
      }

      return currentState.isFinal();
   }

   public void reset()
   {
      this.currentState = startState;
   }
}
