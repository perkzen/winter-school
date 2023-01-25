import React, { FC } from 'react';

interface HeaderProps {
  title: string;
  subtitle: string;
  onClick?: () => void;
  buttonLabel?: string;
}

const Header: FC<HeaderProps> = ({ title, subtitle, onClick, buttonLabel }) => {
  return (
    <div className={'flex flex-row'}>
      <div className={'grow'}>
        <h1 className="text-3xl font-bold text-green-500">{title}</h1>
        <h2 className={'text-gray-600'}>{subtitle}</h2>
      </div>
      {buttonLabel && (
        <div className={'flex items-center'}>
          <button
            className={'shadow-lg bg-green-500 rounded-full p-3'}
            onClick={onClick}
          >
            {buttonLabel}
          </button>
        </div>
      )}
    </div>
  );
};

export default Header;
