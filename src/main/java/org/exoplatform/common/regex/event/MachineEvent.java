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
package org.exoplatform.common.regex.event;

import org.exoplatform.common.regex.State;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date 7/7/11
 */
public class MachineEvent<C, A>
{

   private final State<C> machineState;

   private final A machineStackSymbol;

   private final String name;

   public MachineEvent(String name, State<C> state, A symbol)
   {
      this.name = name;
      this.machineState = state;
      this.machineStackSymbol = symbol;
   }

   public MachineEvent(State<C> state, A symbol)
   {
      this(state.getLabel(), state, symbol);
   }

   @Override
   public boolean equals(Object obj)
   {
      if(! (obj instanceof MachineEvent))
      {
         return false;
      }

      MachineEvent e = (MachineEvent<C, A>)obj;

      return (this == e) || (this.machineState.equals(e.machineState) && this.machineStackSymbol.equals(e.machineStackSymbol));
   }
}
